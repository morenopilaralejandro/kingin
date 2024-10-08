drop table if exists aux_egg_grp;
create temporary table aux_egg_grp (
    egg_grp_code varchar(32),
    egg_grp_name_en varchar(32),
    egg_grp_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/egg-grp.csv'
into table aux_egg_grp 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
egg_grp_code,
egg_grp_name_en,
egg_grp_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_egg_grp;
create procedure proc_insrt_egg_grp()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vEggGrpCode varchar(32) default '';
    declare vEggGrpNameEn varchar(32) default '';
    declare vEggGrpNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_egg_grp;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from egg_grp;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vEggGrpCode,
            vEggGrpNameEn,
            vEggGrpNameJa;

        if continueCur1 = 1 then
            insert into egg_grp (
                egg_grp_code,
                egg_grp_name_en,
                egg_grp_name_ja
            ) values (
                vEggGrpCode,
                vEggGrpNameEn,
                vEggGrpNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_egg_grp;
end
&&
delimiter ;
call proc_insrt_egg_grp();
