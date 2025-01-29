drop table if exists aux_pd_spaw_hg;
create temporary table aux_pd_spaw_hg (
    zone varchar(32),
    pd varchar(32),
    lv_min varchar(32),
    lv_max varchar(32),
    rate varchar(32),
    enc varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pd-spaw-hg.csv'
into table aux_pd_spaw_hg 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
zone,
pd,
lv_min,
lv_max,
rate,
enc
);

delimiter &&
drop procedure if exists proc_insrt_pd_spaw_hg;
create procedure proc_insrt_pd_spaw_hg()
begin
	declare i int default 1;

    declare idPd int default 0;
    declare idZone int default 0;
    declare idEnc int default 0;

    declare intLvMin int default 0; 
    declare intLvMax int default 0; 
    declare intRate int default 0; 

    /*cur1 variables*/
    declare vPd varchar(32) default '';
    declare vZone varchar(32) default '';  
    declare vEnc varchar(32) default '';
    declare vLvMin varchar(32) default '';  
    declare vLvMax varchar(32) default '';
    declare vRate varchar(32) default '';    

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pd_spaw_hg;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pd_spaw_hg;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vZone,
            vPd,
            vLvMin,
            vLvMax,
            vRate,
            vEnc;

        set idPd = 0;
        set idZone = 0;
        set idEnc = 0;

        if continueCur1 = 1 then
            select pd_id into idPd 
                from pd
                where pd_name_en = vPd;

            select zone_id into idZone 
                from zone
                where zone_code = vZone;

            select enc_id into idEnc 
                from enc
                where enc_code = vEnc;

            if vLvMin = '' then
                set intLvMin = null;
            else
                set intLvMin = cast(vLvMin as unsigned);
            end if; 

            if vLvMax = '' then
                set intLvMax = null;
            else
                set intLvMax = cast(vLvMax as unsigned);
            end if; 

            if vRate = '' then
                set intRate = null;
            else
                set intRate = cast(vRate as unsigned);
            end if; 

            insert into pd_spaw_hg (
                pd_id,
                zone_id,
                enc_id,
                lv_min,
                lv_max,
                rate
            ) values (
                idPd,
                idZone,
                idEnc,
                intLvMin,
                intLvMax,
                intRate
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pd_spaw_hg;
end
&&
delimiter ;
call proc_insrt_pd_spaw_hg();
