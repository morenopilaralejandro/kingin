drop table if exists aux_pd_evo_pd;
create temporary table aux_pd_evo_pd (
    pd_name_sta varchar(32),
    pd_name_end varchar(32),
    evo_cond_code varchar(32),
    lv varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pd-evo-pd.csv'
into table aux_pd_evo_pd 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pd_name_sta,
pd_name_end,
evo_cond_code,
lv
);

delimiter &&
drop procedure if exists proc_insrt_pd_evo_pd;
create procedure proc_insrt_pd_evo_pd()
begin
	declare i int default 1;

    declare idPdSta int default 0;
    declare idPdStaEnd int default 0;
    declare idEvoCond int default 0;

    declare intLv int default 0;

    /*cur1 variables*/
    declare vPdNameSta varchar(32) default '';
    declare vPdNameEnd varchar(32) default '';
    declare vEvoCondCode varchar(32) default '';
    declare vLv varchar(32) default 0;

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pd_evo_pd;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pd_evo_pd;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vPdNameSta,
            vPdNameEnd,
            vEvoCondCode,
            vLv;

        set idPdStaEnd = 0;
        set idPdSta = 0;
        set idEvoCond = 0;

        if continueCur1 = 1 then
            select pd_id into idPdSta 
                from pd 
                where pd_name_ja = vPdNameSta;

            select pd_id into idPdStaEnd 
                from pd 
                where pd_name_ja = vPdNameEnd;

            select evo_cond_id into idEvoCond 
                from evo_cond 
                where evo_cond_code = vEvoCondCode;

            if vLv = 'null' then
                set intLv = null;
            else
                set intLv = cast(vLv as unsigned);
            end if; 

            insert into pd_evo_pd (
                pd_id_sta,
                pd_id_end,
                evo_cond_id,
                lv
            ) values (
                idPdSta,
                idPdStaEnd,
                idEvoCond,
                intLv
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pd_evo_pd;
end
&&
delimiter ;
call proc_insrt_pd_evo_pd();
