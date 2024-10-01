drop table if exists aux_abil;
create temporary table aux_abil (
    abil_code varchar(32),
    abil_name_en varchar(32),
    abil_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/abil.csv'
into table aux_abil 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
abil_code,
abil_name_en,
abil_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_abil;
create procedure proc_insrt_abil()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vAbilCode varchar(32) default '';
    declare vAbilNameEn varchar(32) default '';
    declare vAbilNameJa varchar(32) default '';


    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_abil;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from abil;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vAbilCode,
            vAbilNameEn,
            vAbilNameJa;

        if continueCur1 = 1 then
            insert into abil (
                abil_code,
                abil_name_en,
                abil_name_ja
            ) values (
                vAbilCode,
                vAbilNameEn,
                vAbilNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_abil;
end
&&
delimiter ;
call proc_insrt_abil();
