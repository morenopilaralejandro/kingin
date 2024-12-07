drop table if exists aux_item_mach_obt;
create temporary table aux_item_mach_obt (
    item_mach_obt_code varchar(32),
    item_mach_obt_name_en varchar(32),	
    item_mach_obt_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/item-mach-obt.csv'
into table aux_item_mach_obt 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
item_mach_obt_code,
item_mach_obt_name_en,	
item_mach_obt_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_item_mach_obt;
create procedure proc_insrt_item_mach_obt()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vItemMachObtCode varchar(32) default '';
    declare vItemMachObtNameEn varchar(32) default '';
    declare vItemMachObtNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_item_mach_obt;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from item_mach_obt;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vItemMachObtCode,
            vItemMachObtNameEn,
            vItemMachObtNameJa;
        if continueCur1 = 1 then
            /*TODO*/
            insert into item_mach_obt (
                item_mach_obt_code,
                item_mach_obt_name_en,	
                item_mach_obt_name_ja
            ) values (
                vItemMachObtCode,
                vItemMachObtNameEn,
                vItemMachObtNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_item_mach_obt;
end
&&
delimiter ;
call proc_insrt_item_mach_obt();
