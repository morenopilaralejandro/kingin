drop table if exists aux_pd_yiel_stat;
create temporary table aux_pd_yiel_stat (
    pd_name varchar(32),
    stat_code varchar(32),
    amount int
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pd-yiel-stat.csv'
into table aux_pd_yiel_stat 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pd_name,
stat_code,
amount
);

delimiter &&
drop procedure if exists proc_insrt_pd_yiel_stat;
create procedure proc_insrt_pd_yiel_stat()
begin
	declare i int default 1;

    declare idPd int default 0;
    declare idStat int default 0;

    /*cur1 variables*/
    declare vPdName varchar(32) default '';
    declare vStatCode varchar(32) default '';
    declare vAmount int default 0;

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pd_yiel_stat;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pd_yiel_stat;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vPdName,
            vStatCode;

        set idStat = 0;
        set idPd = 0;

        if continueCur1 = 1 then
            select pd_id into idPd 
                from pd 
                where pd_name_en = vPdName;

            select stat_id into idStat 
                from stat 
                where stat_code = vStatCode;

            insert into pd_yiel_stat (
                pd_id,
                stat_id,
                amount
            ) values (
                idPd,
                idStat,
                vAmount
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pd_yiel_stat;
end
&&
delimiter ;
call proc_insrt_pd_yiel_stat();
