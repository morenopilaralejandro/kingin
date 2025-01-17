drop table if exists aux_pd_lina_evo_fam;
create temporary table aux_pd_lina_evo_fam (
    pd_name varchar(32),
    evo_fam_code varchar(32),
    ordr int
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pd-lina-evo-fam.csv'
into table aux_pd_lina_evo_fam 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pd_name,
evo_fam_code,
ordr
);

delimiter &&
drop procedure if exists proc_insrt_pd_lina_evo_fam;
create procedure proc_insrt_pd_lina_evo_fam()
begin
	declare i int default 1;

    declare idPd int default 0;
    declare idEvoFam int default 0;

    /*cur1 variables*/
    declare vPdName varchar(32) default '';
    declare vEvoFamCode varchar(32) default '';
    declare vOrdr int default 0;

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pd_lina_evo_fam;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pd_lina_evo_fam;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vPdName,
            vEvoFamCode;

        set idEvoFam = 0;
        set idPd = 0;

        if continueCur1 = 1 then
            select pd_id into idPd 
                from pd 
                where pd_name_en = vPdName;

            select evo_fam_id into idEvoFam 
                from evo_fam 
                where evo_fam_code = vEvoFamCode;

            insert into pd_lina_evo_fam (
                pd_id,
                evo_fam_id,
                ordr
            ) values (
                idPd,
                idEvoFam,
                vOrdr
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pd_lina_evo_fam;
end
&&
delimiter ;
call proc_insrt_pd_lina_evo_fam();
