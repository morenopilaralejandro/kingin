drop table if exists aux_pd;
create temporary table aux_pd (
    pd_code varchar(32),
    pd_index varchar(32),
    pd_name_en varchar(32),
    pd_name_ja varchar(32),
    pd_img varchar(32),
    pd_cap_rate varchar(32),
    pd_xp varchar(32),
    pd_hap varchar(32),
    pd_base_hp int,
    pd_base_atk int,
    pd_base_def int,
    pd_base_spatk int,
    pd_base_spdef int,
    pd_base_spe int,
    pd_yiel_hp int,
    pd_yiel_atk int,
    pd_yiel_def int,
    pd_yiel_spatk int,
    pd_yiel_spdef int,
    pd_yiel_spe int,
    gndr_m_rate varchar(32),
    gndr_f_rate varchar(32),
    gndr_n_rate varchar(32),
    egg_cyc varchar(32),
    exp_grp varchar(32),
    type1 varchar(32),
    type2 varchar(32),
    egg_grp1 varchar(32),
    egg_grp2 varchar(32),
    abil1 varchar(32),
    abil2 varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pd.csv'
into table aux_pd 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pd_code,
pd_index,
pd_name_en,
pd_name_ja,
pd_img,
pd_cap_rate,
pd_xp,
pd_hap,
pd_base_hp,
pd_base_atk,
pd_base_def,
pd_base_spatk,
pd_base_spdef,
pd_base_spe,
pd_yiel_hp,
pd_yiel_atk,
pd_yiel_def,
pd_yiel_spatk,
pd_yiel_spdef,
pd_yiel_spe,
gndr_m_rate,
gndr_f_rate,
gndr_n_rate,
egg_cyc,
exp_grp,
type1,
type2,
egg_grp1,
egg_grp2,
abil1,
abil2
);

delimiter &&
drop procedure if exists proc_insrt_pd;
create procedure proc_insrt_pd()
begin
	declare i int default 1;

    declare idEggCyc int default 0;
    declare idExpGrp int default 0;
    declare idType1 int default 0;
    declare idType2 int default 0;
    declare idEggGrp1 int default 0;
    declare idEggGrp2 int default 0;
    declare idAbil1 int default 0;
    declare idAbil2 int default 0;

    declare intPdIndex int default 0;
    declare intPdCapRate int default 0;
    declare intPdXp int default 0;
    declare intPdHap int default 0;
    declare intGndrMRate int default 0;
    declare intGndrFRate int default 0;
    declare intGndrNRate int default 0;

    /*cur1 variables*/
    declare vPdCode varchar(32) default '';
    declare vPdIndex varchar(32) default '';
    declare vPdNameEn varchar(32) default '';
    declare vPdNameJa varchar(32) default '';
    declare vPdImg varchar(32) default '';
    declare vPdCapRate varchar(32) default '';
    declare vPdXp varchar(32) default '';
    declare vPdHap varchar(32) default '';
    declare vPdBaseHp int default 0;
    declare vPdBaseAtk int default 0;
    declare vPdBaseDef int default 0;
    declare vPdBaseSpatk int default 0;
    declare vPdBaseSpdef int default 0;
    declare vPdBaseSpe int default 0;
    declare vPdYielHp int default 0;
    declare vPdYielAtk int default 0;
    declare vPdYielDef int default 0;
    declare vPdYielSpatk int default 0;
    declare vPdYielSpdef int default 0;
    declare vPdYielSpe int default 0;
    declare vGndrMRate varchar(32) default '';
    declare vGndrFRate varchar(32) default '';
    declare vGndrNRate varchar(32) default '';
    declare vEggCyc varchar(32) default '';
    declare vExpGrp varchar(32) default '';
    declare vType1 varchar(32) default '';
    declare vType2 varchar(32) default '';
    declare vEggGrp1 varchar(32) default '';
    declare vEggGrp2 varchar(32) default '';
    declare vAbil1 varchar(32) default '';
    declare vAbil2 varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pd;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pd;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into
            vPdCode,
            vPdIndex,
            vPdNameEn,
            vPdNameJa,
            vPdImg,
            vPdCapRate,
            vPdXp,
            vPdHap,
            vPdBaseHp,
            vPdBaseAtk,
            vPdBaseDef,
            vPdBaseSpatk,
            vPdBaseSpdef,
            vPdBaseSpe,
            vPdYielHp,
            vPdYielAtk,
            vPdYielDef,
            vPdYielSpatk,
            vPdYielSpdef,
            vPdYielSpe,
            vGndrMRate,
            vGndrFRate,
            vGndrNRate,
            vEggCyc,
            vExpGrp,
            vType1,
            vType2,
            vEggGrp1,
            vEggGrp2,
            vAbil1,
            vAbil2;

        set idEggCyc = 0;
        set idExpGrp = 0;
        set idType1 = 0;
        set idType2 = 0;
        set idEggGrp1 = 0;
        set idEggGrp2 = 0;
        set idAbil1 = 0;
        set idAbil2 = 0;

        if continueCur1 = 1 then
            select egg_cyc_id into idEggCyc 
                from egg_cyc 
                where egg_cyc_val = vEggCyc;

            select exp_grp_id into idExpGrp 
                from exp_grp 
                where exp_grp_name_en = vExpGrp;

            select type_id into idType1 
                from type 
                where type_name_en = vType1;

            select type_id into idType2 
                from type 
                where type_name_en = vType2;

            select egg_grp_id into idEggGrp1 
                from egg_grp 
                where egg_grp_name_en = vEggGrp1;

            select egg_grp_id into idEggGrp2
                from egg_grp 
                where egg_grp_name_en = vEggGrp2;

            select abil_id into idAbil1
                from abil 
                where abil_name_en = vAbil1;

            select abil_id into idAbil2
                from abil 
                where abil_name_en = vAbil2;

            set continueCur1 = 1;            

            if vPdIndex = 'null' then
                set intPdIndex = null;
            else
                set intPdIndex = cast(vPdIndex as unsigned);
            end if; 

            if vPdCapRate = 'null' then
                set intPdCapRate = null;
            else
                set intPdCapRate = cast(vPdCapRate as unsigned);
            end if; 

            if vPdXp = 'null' then
                set intPdXp = null;
            else
                set intPdXp = cast(vPdXp as unsigned);
            end if; 

            if vPdHap = 'null' then
                set intPdHap = null;
            else
                set intPdHap = cast(vPdHap as unsigned);
            end if;

            if vGndrMRate = '' then
                set intGndrMRate = null;
            else
                set intGndrMRate = cast(vGndrMRate as unsigned);
            end if;

            if vGndrFRate = '' then
                set intGndrFRate = null;
            else
                set intGndrFRate = cast(vGndrFRate as unsigned);
            end if;

            if vGndrNRate = '' then
                set intGndrNRate = null;
            else
                set intGndrNRate = cast(vGndrNRate as unsigned);
            end if;

            insert into pd (
                pd_id,
                pd_code,
                pd_index,
                pd_name_en,
                pd_name_ja,
                pd_img,
                pd_cap_rate,
                pd_hap,
                pd_base_hp,
                pd_base_atk,
                pd_base_def,
                pd_base_spatk,
                pd_base_spdef,
                pd_base_spe,
                egg_cyc_id,
                exp_grp_id
            ) values (
                i,
                vPdCode,
                vPdIndex,
                vPdNameEn,
                vPdNameJa,
                vPdImg,
                intPdCapRate,
                intPdHap,
                vPdBaseHp,
                vPdBaseAtk,
                vPdBaseDef,
                vPdBaseSpatk,
                vPdBaseSpdef,
                vPdBaseSpe,
                idEggCyc,
                idExpGrp
            );

            if idType1 != 0 then
                insert into pd_evok_type (
                    pd_id,
                    type_id
                ) values (
                    i,
                    idType1
                );
            end if;

            if idType2 != 0 then
                insert into pd_evok_type (
                    pd_id,
                    type_id
                ) values (
                    i,
                    idType2
                );
            end if;

            if idEggGrp1 != 0 then
                insert into pd_belo_egg_grp (
                    pd_id,
                    egg_grp_id
                ) values (
                    i,
                    idEggGrp1
                );
            end if;

            if idEggGrp2 != 0 then
                insert into pd_belo_egg_grp (
                    pd_id,
                    egg_grp_id
                ) values (
                    i,
                    idEggGrp2
                );
            end if;

            if idAbil1 != 0 then
                insert into pd_tra_abil (
                    pd_id,
                    abil_id
                ) values (
                    i,
                    idAbil1
                );
            end if;

            if idAbil2 != 0 then
                insert into pd_tra_abil (
                    pd_id,
                    abil_id
                ) values (
                    i,
                    idAbil2
                );
            end if;
        end if;
        set i = i + 1;
	end while;
	close cur1;
    drop table if exists aux_pd;
end
&&
delimiter ;
call proc_insrt_pd();
