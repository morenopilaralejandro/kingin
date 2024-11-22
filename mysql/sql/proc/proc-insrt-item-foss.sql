drop table if exists aux_item_foss;
create temporary table aux_item_foss (
    item varchar(32),
    pd varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/item-foss.csv'
into table aux_item_foss 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
item,
pd
);

delimiter &&
drop procedure if exists proc_insrt_item_foss;
create procedure proc_insrt_item_foss()
begin
	declare i int default 1;

    declare idItem int default 0;
    declare idPd int default 0;

    /*cur1 variables*/
    declare vItem varchar(32) default '';
    declare vPd varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_item_foss;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from item_foss;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into
            vItem,
            vPd;

        if continueCur1 = 1 then
            select item_id into idItem 
                from item
                where item_code = vItem;

            select pd_id into idPd 
                from pd
                where pd_name_en = vPd;

            set continueCur1 = 1;            

            insert into item_foss (
                item_foss_id,
                pd_id
            ) values (
                idItem,
                idPd
            );
        end if;
        set i = i + 1;
	end while;
	close cur1;
    drop table if exists aux_item_foss;
end
&&
delimiter ;
call proc_insrt_item_foss();
