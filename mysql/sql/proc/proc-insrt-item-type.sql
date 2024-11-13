drop table if exists aux_item_type;
create temporary table aux_item_type (
    item_type_code varchar(32),
    item_type_name_en varchar(32),	
    item_type_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/item-type.csv'
into table aux_item_type 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
item_type_code,
item_type_name_en,	
item_type_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_item_type;
create procedure proc_insrt_item_type()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vItemTypeCode varchar(32) default '';
    declare vItemTypeNameEn varchar(32) default '';
    declare vItemTypeNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_item_type;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from item_type;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into v;
        if continueCur1 = 1 then
            /*TODO*/
            insert into item_type (
                item_type_code,
                item_type_name_en,	
                item_type_name_ja
            ) values (
                vItemTypeCode,
                vItemTypeNameEn,
                vItemTypeNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_item_type;
end
&&
delimiter ;
call proc_insrt_item_type();
