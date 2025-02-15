    drop table if exists aux_pw_crse_spaw_pd;
create temporary table aux_pw_crse_spaw_pd (
    pw_crse varchar(32),
    pd varchar(32),
    pw_grp varchar(32),
    step varchar(32),
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pw-crse-spaw-pd.csv'
into table aux_pw_crse_spaw_pd 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pw_crse,
pd,
pw_grp,
step
);

delimiter &&
drop procedure if exists proc_insrt_pw_crse_spaw_pd;
create procedure proc_insrt_pw_crse_spaw_pd()
begin
	declare i int default 1;

    declare idPd int default 0;
    declare idPwCrse int default 0;
    declare idPwGrp int default 0;

    declare intStep int default 0; 


    /*cur1 variables*/
    declare vPwCrse varchar(32) default ''; 
    declare vPd varchar(32) default '';
    declare vPwGrp varchar(32) default '';
    declare vStep varchar(32) default ''; 

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pw_crse_spaw_pd;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pw_crse_spaw_pd;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vPwCrse,
            vPd,
            vPwGrp,
            vStep;

        set idPd = 0;
        set idPwCrse = 0;
        set idPwGrp = 0;

        if continueCur1 = 1 then
            select pd_id into idPd 
                from pd
                where pd_name_en = vPd;

            select pw_crse_id into idPwCrse 
                from pw_crse
                where pw_crse_code = vPwCrse;

            select pw_grp_id into idPwGrp 
                from pw_grp
                where pw_grp_code = vPwGrp;

            if vStep = '' then
                set intStep = null;
            else
                set intStep = cast(vStep as unsigned);
            end if; 

            insert into pw_crse_spaw_pd (
                pd_id,
                pw_crse_id,
                pw_grp_id,
                step
            ) values (
                idPd,
                idPwCrse,
                idPwGrp,
                intStep
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pw_crse_spaw_pd;
end
&&
delimiter ;
call proc_insrt_pw_crse_spaw_pd();
