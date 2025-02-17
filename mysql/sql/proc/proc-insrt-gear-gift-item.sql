drop table if exists aux_gear_gift_item;
create temporary table aux_gear_gift_item (
    gear_call_code varchar(32),
    item_name varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/gear-gift-item.csv'
into table aux_gear_gift_item 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
gear_call_code,
item_name
);

delimiter &&
drop procedure if exists proc_insrt_gear_gift_item;
create procedure proc_insrt_gear_gift_item()
begin
	declare i int default 1;

    declare idGearCall int default 0;
    declare idItem int default 0;

    /*cur1 variables*/
    declare vGearCallCode varchar(32) default '';
    declare vItemName varchar(32) default '';    

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_gear_gift_item;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from gear_gift_item;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vGearCallCode,
            vItemName;

        set idGearCall = 0;
        set idItem = 0;

        if continueCur1 = 1 then
            select gear_call_id into idGearCall 
                from gear_call 
                where gear_call_code = vGearCallCode;

            select item_id into idItem 
                from item 
                where item_name_en = vItemName;

            insert into gear_gift_item (
                gear_call_id,
                item_id
            ) values (
                idGearCall,
                idItem
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_gear_gift_item;
end
&&
delimiter ;
call proc_insrt_gear_gift_item();
