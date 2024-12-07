drop table if exists aux_item_cat;
create temporary table aux_item_cat (
    item_cat_code varchar(32),
    item_cat_name_en varchar(32),	
    item_cat_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/item-cat.csv'
into table aux_item_cat 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
item_cat_code,
item_cat_name_en,	
item_cat_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_item_cat;
create procedure proc_insrt_item_cat()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vItemCatCode varchar(32) default '';
    declare vItemCatNameEn varchar(32) default '';
    declare vItemCatNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_item_cat;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from item_cat;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vItemCatCode, 
            vItemCatNameEn, 
            vItemCatNameJa;
        if continueCur1 = 1 then
            /*TODO*/
            insert into item_cat (
                item_cat_code,
                item_cat_name_en,	
                item_cat_name_ja
            ) values (
                vItemCatCode,
                vItemCatNameEn,
                vItemCatNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_item_cat;
end
&&
delimiter ;
call proc_insrt_item_cat();
