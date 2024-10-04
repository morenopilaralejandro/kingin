drop table if exists aux_abil_eff_type;
create temporary table aux_abil_eff_type (
    abil_eff_type_code varchar(32),
    abil_eff_type_name_en varchar(1000),
    abil_eff_type_name_ja varchar(1000)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/abil-eff-type.csv'
into table aux_abil_eff_type 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
abil_eff_type_code,
abil_eff_type_name_en,
abil_eff_type_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_abil_eff_type;
create procedure proc_insrt_abil_eff_type()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vAbilEffTypeCode varchar(32) default '';
    declare vAbilEffTypeNameEn varchar(1000) default '';
    declare vAbilEffTypeNameJa varchar(1000) default '';


    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_abil_eff_type;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from abil_eff_type;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vAbilEffTypeCode,
            vAbilEffTypeNameEn,
            vAbilEffTypeNameJa;

        if continueCur1 = 1 then
            insert into abil_eff_type (
                abil_eff_type_code,
                abil_eff_type_name_en,
                abil_eff_type_name_ja
            ) values (
                vAbilEffTypeCode,
                vAbilEffTypeNameEn,
                vAbilEffTypeNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_abil_eff_type;
end
&&
delimiter ;
call proc_insrt_abil_eff_type();
