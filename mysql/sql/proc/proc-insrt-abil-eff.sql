drop table if exists aux_abil_eff;
create temporary table aux_abil_eff (
    abil_eff_code varchar(32),
    abil_eff_desc_en varchar(1000),
    abil_eff_desc_ja varchar(1000)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/abil-eff.csv'
into table aux_abil_eff 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
abil_eff_code,
abil_eff_desc_en,
abil_eff_desc_ja
);

delimiter &&
drop procedure if exists proc_insrt_abil_eff;
create procedure proc_insrt_abil_eff()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vAbilEffCode varchar(32) default '';
    declare vAbilEffDescEn varchar(1000) default '';
    declare vAbilEffDescJa varchar(1000) default '';


    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_abil_eff;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from abil_eff;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vAbilEffCode,
            vAbilEffDescEn,
            vAbilEffDescJa;

        if continueCur1 = 1 then
            insert into abil_eff (
                abil_eff_code,
                abil_eff_desc_en,
                abil_eff_desc_ja
            ) values (
                vAbilEffCode,
                vAbilEffDescEn,
                vAbilEffDescJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_abil_eff;
end
&&
delimiter ;
call proc_insrt_abil_eff();
