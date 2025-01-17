drop table if exists aux_pd_hold_item;
create temporary table aux_pd_hold_item (
    pd_name varchar(32),
    item_name varchar(32),
    rate int
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pd-hold-item.csv'
into table aux_pd_hold_item 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pd_name,
item_name,
rate
);

delimiter &&
drop procedure if exists proc_insrt_pd_hold_item;
create procedure proc_insrt_pd_hold_item()
begin
	declare i int default 1;

    declare idPd int default 0;
    declare idItem int default 0;

    /*cur1 variables*/
    declare vPdName varchar(32) default '';
    declare vItemName varchar(32) default '';
    declare vRate int default 0;

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pd_hold_item;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pd_hold_item;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vPdName,
            vItemName;

        set idItem = 0;
        set idPd = 0;

        if continueCur1 = 1 then
            select pd_id into idPd 
                from pd 
                where pd_name_en = vPdName;

            select item_id into idItem 
                from item 
                where item_name_en = vItemName;

            insert into pd_hold_item (
                pd_id,
                item_id,
                rate
            ) values (
                idPd,
                idItem,
                vRate
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pd_hold_item;
end
&&
delimiter ;
call proc_insrt_pd_hold_item();
