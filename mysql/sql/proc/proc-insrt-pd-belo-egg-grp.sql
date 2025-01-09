drop table if exists aux_pd_belo_egg_grp;
create temporary table aux_pd_belo_egg_grp (
    pd_name varchar(32),
    egg_grp_name varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pd-belo-egg-grp.csv'
into table aux_pd_belo_egg_grp 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pd_name,
egg_grp_name
);

delimiter &&
drop procedure if exists proc_insrt_pd_belo_egg_grp;
create procedure proc_insrt_pd_belo_egg_grp()
begin
	declare i int default 1;

    declare idPd int default 0;
    declare idEggGrp int default 0;

    /*cur1 variables*/
    declare vPdName varchar(32) default '';
    declare vEggGrpName varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pd_belo_egg_grp;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pd_belo_egg_grp;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vPdName,
            vEggGrpName;

        set idEggGrp = 0;
        set idPd = 0;

        if continueCur1 = 1 then
            select pd_id into idPd 
                from pd 
                where pd_name_en = vPdName;

            select egg_grp_id into idEggGrp 
                from egg_grp 
                where egg_grp_name_en = vEggGrpName;

            insert into pd_belo_egg_grp (
                pd_id,
                egg_grp_id
            ) values (
                idPd,
                idEggGrp
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pd_belo_egg_grp;
end
&&
delimiter ;
call proc_insrt_pd_belo_egg_grp();
