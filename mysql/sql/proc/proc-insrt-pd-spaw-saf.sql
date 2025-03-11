drop table if exists aux_pd_spaw_saf;
create temporary table aux_pd_spaw_saf (
    zone varchar(32),
	pd varchar(32),
    enc	 varchar(32),
    saf_blk1  varchar(32),
    amount1	 varchar(32),
    saf_blk2  varchar(32),
    amount2  varchar(32),
    lv_min  varchar(32),
    lv_max  varchar(32),
    days  varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pd-spaw-saf.csv'
into table aux_pd_spaw_saf 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
zone,
pd,
enc,
saf_blk1,
amount1,
saf_blk2,
amount2,
lv_min,
lv_max,
days
);

delimiter &&
drop procedure if exists proc_insrt_pd_spaw_saf;
create procedure proc_insrt_pd_spaw_saf()
begin
	declare i int default 1;

    declare idPd int default 0;
    declare idZone int default 0;
    declare idEnc int default 0;
    declare idSafBlk1 int default 0;
    declare idSafBlk2 int default 0;

    declare intLvMin int default 0; 
    declare intLvMax int default 0; 
    declare intAmount1 int default 0; 
    declare intAmount2 int default 0; 
    declare intDays int default 0; 

    /*cur1 variables*/
    declare vZone varchar(32) default '';
    declare vPd varchar(32) default '';
    declare vEnc varchar(32) default '';
    declare vSafBlk1 varchar(32) default '';
    declare vAmount1 varchar(32) default '';
    declare vSafBlk2 varchar(32) default '';
    declare vAmount2 varchar(32) default '';
    declare vLvMin varchar(32) default '';
    declare vLvMax varchar(32) default '';
    declare vDays varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pd_spaw_saf;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pd_spaw_saf;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vZone,
            vPd,
            vEnc,
            vSafBlk1, 
            vAmount1,
            vSafBlk2,
            vAmount2,
            vLvMin,
            vLvMax,
            vDays;

        set idPd = 0;
        set idZone = 0;
        set idEnc = 0;
        set idSafBlk1 = 0;
        set idSafBlk2 = 0;

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


            if vSafBlk1 = '' then 
                set idSafBlk1 = null;
            else 
                select saf_blk_id into idSafBlk1 
                    from saf_blk
                    where saf_blk_name_en = vSafBlk1;
            end if;

            if vSafBlk2 = '' then 
                set idSafBlk2 = null;
            else 
                select saf_blk_id into idSafBlk2 
                    from saf_blk
                    where saf_blk_name_en = vSafBlk2;
            end if;

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

            if vAmount1 = '' then
                set intAmount1 = null;
            else
                set intAmount1 = cast(vAmount1 as unsigned);
            end if; 

            if vAmount2 = '' then
                set intAmount2 = null;
            else
                set intAmount2 = cast(vAmount2 as unsigned);
            end if; 

            if vDays = '' then
                set intDays = null;
            else
                set intDays = cast(vDays as unsigned);
            end if; 

            insert into pd_spaw_saf (
                pd_id,
                zone_id,
                enc_id,
                saf_blk1_id,
                saf_blk2_id,
                lv_min,
                lv_max,
                amount1,
                amount2,
                days
            ) values (
                idPd,
                idZone,
                idEnc,
                idSafBlk1,
                idSafBlk2,
                intLvMin,
                intLvMax,
                intAmount1,
                intAmount2,
                intDays
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pd_spaw_saf;
end
&&
delimiter ;
call proc_insrt_pd_spaw_saf();
