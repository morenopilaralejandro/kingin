drop table if exists aux_abil;
create temporary table aux_abil (
    abil_code varchar(32),
    abil_name_en varchar(32),
    abil_name_ja varchar(32),
    abil_is_role varchar(32),
    abil_is_rece varchar(32),
    abil_is_entr varchar(32),
    abil_is_trac varchar(32),
    abil_is_sksw varchar(32),
    abil_is_gast varchar(32),
    abil_is_mold varchar(32),
    abil_is_tran varchar(32)
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
abil_name_ja,
abil_is_role,
abil_is_rece,
abil_is_entr,
abil_is_trac,
abil_is_sksw,
abil_is_gast,
abil_is_mold,
abil_is_tran
);

delimiter &&
drop procedure if exists proc_insrt_abil;
create procedure proc_insrt_abil()
begin
	declare i int default 1;

    declare boolIsRole bool default true;
    declare boolIsRece bool default true;
    declare boolIsEntr bool default true;
    declare boolIsTrac bool default true;
    declare boolIsSksw bool default true;
    declare boolIsGast bool default true;
    declare boolIsMold bool default false;
    declare boolIsTran bool default true;

    /*cur1 variables*/
    declare vAbilCode varchar(32) default '';
    declare vAbilNameEn varchar(32) default '';
    declare vAbilNameJa varchar(32) default '';
    declare vAbilIsRole varchar(32) default '';
    declare vAbilIsRece varchar(32) default '';
    declare vAbilIsEntr varchar(32) default '';
    declare vAbilIsTrac varchar(32) default '';
    declare vAbilIsSksw varchar(32) default '';
    declare vAbilIsGast varchar(32) default '';
    declare vAbilIsMold varchar(32) default '';
    declare vAbilIsTran varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_abil;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from abil;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vAbilCode,
            vAbilNameEn,
            vAbilNameJa,
            vAbilIsRole,
            vAbilIsRece,
            vAbilIsEntr,
            vAbilIsTrac,
            vAbilIsSksw,
            vAbilIsGast,
            vAbilIsMold,
            vAbilIsTran;

        if continueCur1 = 1 then
            if lower(vAbilIsRole) = 'yes' then
                set boolIsRole = false;
            else 
                set boolIsRole = true;
            end if;

            if lower(vAbilIsRece) = 'yes' then
                set boolIsRece = false;
            else 
                set boolIsRece = true;
            end if;

            if lower(vAbilIsEntr) = 'yes' then
                set boolIsEntr = false;
            else 
                set boolIsEntr = true;
            end if;

            if lower(vAbilIsTrac) = 'yes' then
                set boolIsTrac = false;
            else 
                set boolIsTrac = true;
            end if;

            if lower(vAbilIsSksw) = 'yes' then
                set boolIsSksw = false;
            else 
                set boolIsSksw = true;
            end if;

            if lower(vAbilIsGast) = 'yes' then
                set boolIsGast = false;
            else 
                set boolIsGast = true;
            end if;

            if lower(vAbilIsMold) = 'yes' then
                set boolIsMold = true;
            else 
                set boolIsMold = false;
            end if;

            if lower(vAbilIsTran) = 'yes' then
                set boolIsTran = false;
            else 
                set boolIsTran = true;
            end if;

            insert into abil (
                abil_code,
                abil_name_en,
                abil_name_ja,
                abil_is_role,
                abil_is_rece,
                abil_is_entr,
                abil_is_trac,
                abil_is_sksw,
                abil_is_gast,
                abil_is_mold,
                abil_is_tran
            ) values (
                vAbilCode,
                vAbilNameEn,
                vAbilNameJa,
                boolIsRole,
                boolIsRece,
                boolIsEntr,
                boolIsTrac,
                boolIsSksw,
                boolIsGast,
                boolIsMold,
                boolIsTran
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_abil;
end
&&
delimiter ;
call proc_insrt_abil();
