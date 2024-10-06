drop table if exists aux_abil_eff;
create temporary table aux_abil_eff (
    abil_eff_code varchar(32),
    abil_eff_desc_en varchar(1000),
    abil_eff_desc_ja varchar(1000),
    abil_eff_type_code varchar(32)
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
abil_eff_desc_ja,
abil_eff_type_code
);

delimiter &&
drop procedure if exists proc_insrt_abil_eff;
create procedure proc_insrt_abil_eff()
begin
	declare i int default 1;

    declare idAbilEffType int default 0;

    /*cur1 variables*/
    declare vAbilEffCode varchar(32) default '';
    declare vAbilEffDescEn varchar(1000) default '';
    declare vAbilEffDescJa varchar(1000) default '';
    declare vAbilEffTypeCode varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_abil_eff;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from abil_eff;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vAbilEffCode,
            vAbilEffDescEn,
            vAbilEffDescJa,
            vAbilEffTypeCode;

        set idAbilEffType = 0;

        if continueCur1 = 1 then
            select abil_eff_type_id into idAbilEffType 
                from abil_eff_type 
                where abil_eff_type_code = vAbilEffTypeCode;

            insert into abil_eff (
                abil_eff_code,
                abil_eff_desc_en,
                abil_eff_desc_ja,
                abil_eff_type_id
            ) values (
                vAbilEffCode,
                vAbilEffDescEn,
                vAbilEffDescJa,
                idAbilEffType
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_abil_eff;
end
&&
delimiter ;
call proc_insrt_abil_eff();
