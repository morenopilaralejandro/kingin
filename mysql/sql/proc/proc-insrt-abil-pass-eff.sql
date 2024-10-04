drop table if exists aux_abil_pass_eff;
create temporary table aux_abil_pass_eff (
    abil_code varchar(32),
    abil_eff_code varchar(32),
    abil_eff_type_code varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/abil-pass-eff.csv'
into table aux_abil_pass_eff 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
abil_code,
abil_eff_code,
abil_eff_type_code
);

delimiter &&
drop procedure if exists proc_insrt_abil_pass_eff;
create procedure proc_insrt_abil_pass_eff()
begin
	declare i int default 1;

    declare idAbil int default 0;
    declare idAbilEff int default 0;
    declare idAbilEffType int default 0;

    /*cur1 variables*/
    declare vAbilCode varchar(32) default '';
    declare vAbilEffCode varchar(32) default '';
    declare vAbilEffTypeCode varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_abil_pass_eff;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from abil_pass_eff;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vAbilCode,
            vAbilEffCode,
            vAbilEffTypeCode;

        set idAbil = 0;
        set idAbilEff = 0;
        set idAbilEffType = 0;

        if continueCur1 = 1 then
            select abil_id into idAbil 
                from abil
                where abil_code = vAbilCode;

            select abil_eff_id into idAbilEff 
                from abil_eff 
                where abil_eff_code = vAbilEffCode;

            select abil_eff_type_id into idAbilEffType 
                from abil_eff_type 
                where abil_eff_type_code = vAbilEffTypeCode;

            insert into abil_pass_eff (
                abil_id,
                abil_eff_id,
                abil_eff_type_id
            ) values (
                idAbil,
                idAbilEff,
                idAbilEffType
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_abil_pass_eff;
end
&&
delimiter ;
call proc_insrt_abil_pass_eff();
