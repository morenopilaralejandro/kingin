drop table if exists aux_pd_spaw_hgss;
create temporary table aux_pd_spaw_hgss (
    zone varchar(32),
    pd varchar(32),
    vrs varchar(32),
    enc varchar(32),
    lv_min varchar(32),
    lv_max varchar(32),
    rate_m varchar(32),
    rate_d varchar(32),
    rate_n varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pd-spaw-hgss.csv'
into table aux_pd_spaw_hgss 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
zone,
pd,
vrs,
enc,
lv_min,
lv_max,
rate_m,
rate_d,
rate_n
);

delimiter &&
drop procedure if exists proc_insrt_pd_spaw_hgss;
create procedure proc_insrt_pd_spaw_hgss()
begin
	declare i int default 1;

    declare idPd int default 0;
    declare idZone int default 0;
    declare idEnc int default 0;

    declare intLvMin int default 0; 
    declare intLvMax int default 0; 
    declare intRateM int default 0; 
    declare intRateD int default 0; 
    declare intRateN int default 0; 

    declare boolIsHg bool default false;
    declare boolIsSs bool default false;

    /*cur1 variables*/
    declare vZone varchar(32) default ''; 
    declare vPd varchar(32) default '';
    declare vVrs varchar(32) default '';
    declare vEnc varchar(32) default '';
    declare vLvMin varchar(32) default '';  
    declare vLvMax varchar(32) default '';
    declare vRateM varchar(32) default '';
    declare vRateD varchar(32) default '';
    declare vRateN varchar(32) default '';    

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pd_spaw_hgss;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pd_spaw_hgss;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vZone,
            vPd,
            vVrs,
            vEnc,
            vLvMin, 
            vLvMax,
            vRateM,
            vRateD,
            vRateN;

        set idPd = 0;
        set idZone = 0;
        set idEnc = 0;

        set boolIsHg = 0;
        set boolIsSs = 0;

        if continueCur1 = 1 then
            select pd_id into idPd 
                from pd
                where pd_name_en = vPd;

            select zone_id into idZone 
                from zone
                where zone_code = vZone;
            
            case vEnc
                when 'Grass' then 
                    set vEnc = 'walk';
                when 'Cave' then 
                    set vEnc = 'walk';
                when 'Headbutt (Group A)' then
                    set vEnc = 'head-a';
                when 'Headbutt (Group B)' then
                    set vEnc = 'head-b';
                when 'Headbutt (sp)' then
                    set vEnc = 'head-sp';
                when 'Rock Smash' then
                    set vEnc = 'rock';
                when 'Surfing' then
                    set vEnc = 'surf';
                when 'Fishing (Old Rod)' then
                    set vEnc = 'rod-old';
                when 'Fishing (Good Rod)' then
                    set vEnc = 'rod-good';
                when 'Fishing (Super Rod)' then
                    set vEnc = 'rod-sup';
                when 'Swarm' then
                    set vEnc = 'swar';
                when 'swar' then
                    set vEnc = 'swar-surf';
                when 'Swarm (Old Rod)' then
                    set vEnc = 'swar-old';
                when 'Swarm (Good Rod)' then
                    set vEnc = 'swar-good';
                when 'Swarm (Super Rod)' then
                    set vEnc = 'swar-sup';
                when 'Hoenn Sound' then
                    set vEnc = 'sou-hoen';
                when 'Sinnoh Sound' then
                    set vEnc = 'sou-shin';
                when 'Gift' then
                    set vEnc = 'gift';
                when 'sp' then
                    set vEnc = 'sp';
                else
                    set vEnc = null;
            end case;

            select enc_id into idEnc 
                from enc
                where enc_code = vEnc;

            if vVrs = 'HG/SS' then
                set boolIsHg = true;
                set boolIsSs = true;
            elseif vVrs = 'HG' then
                set boolIsHg = true;
            elseif vVrs = 'SS' then
                set boolIsSs = true;
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

            if vRateM = '' then
                set intRateM = null;
            else
                set intRateM = cast(vRateM as unsigned);
            end if; 

            if vRateD = '' then
                set intRateD = null;
            else
                set intRateD = cast(vRateD as unsigned);
            end if; 

            if vRateN = '' then
                set intRateN = null;
            else
                set intRateN = cast(vRateN as unsigned);
            end if; 

            insert into pd_spaw_hgss (
                pd_id,
                zone_id,
                enc_id,
                is_hg,
                is_ss,
                lv_min,
                lv_max,
                rate_m,
                rate_d,
                rate_n
            ) values (
                idPd,
                idZone,
                idEnc,
                boolIsHg,
                boolIsSs,
                intLvMin,
                intLvMax,
                intRateM,
                intRateD,
                intRateN
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pd_spaw_hgss;
end
&&
delimiter ;
call proc_insrt_pd_spaw_hgss();
