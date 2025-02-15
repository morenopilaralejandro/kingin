drop table if exists aux_pw_crse_loc_item;
create temporary table aux_pw_crse_loc_item (
    pw_crse varchar(32),
    item varchar(32),
    step varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pw-crse-loc-item.csv'
into table aux_pw_crse_loc_item 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pw_crse,
item,
step
);

delimiter &&
drop procedure if exists proc_insrt_pw_crse_loc_item;
create procedure proc_insrt_pw_crse_loc_item()
begin
	declare i int default 1;

    declare idItem int default 0;
    declare idPwCrse int default 0;

    declare intStep int default 0;

    /*cur1 variables*/
    declare vItem varchar(32) default '';
    declare vPwCrse varchar(32) default '';  
    declare vStep varchar(32) default '';  

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pw_crse_loc_item;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pw_crse_loc_item;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vPwCrse,
            vItem,
            vStep;

        set idItem = 0;
        set idPwCrse = 0;

        if continueCur1 = 1 then
            select item_id into idItem 
                from item
                where item_name_en = vItem;

            select pw_crse_id into idPwCrse 
                from pw_crse
                where pw_crse_code = vPwCrse;

            if vStep = '' then
                set intStep = null;
            else
                set intStep = cast(vStep as unsigned);
            end if; 

            insert into pw_crse_loc_item (
                item_id,
                pw_crse_id,
                step
            ) values (
                idItem,
                idPwCrse,
                intStep
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pw_crse_loc_item;
end
&&
delimiter ;
call proc_insrt_pw_crse_loc_item();
