drop table if exists aux_pd_shif_pd;
create temporary table aux_pd_shif_pd (
    pd_ori varchar(32),
    pd_alt varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pd-shif-pd.csv'
into table aux_pd_shif_pd 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pd_ori,
pd_alt
);

delimiter &&
drop procedure if exists proc_insrt_pd_shif_pd;
create procedure proc_insrt_pd_shif_pd()
begin
	declare i int default 1;

    declare idPdOri int default 0;
    declare idPdAlt int default 0;

    /*cur1 variables*/
    declare vPdOri varchar(32) default '';
    declare vPdAlt varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pd_shif_pd;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pd_shif_pd;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vPdOri,
            vPdAlt;

        set idPdAlt = 0;
        set idPdOri = 0;

        if continueCur1 = 1 then
            select pd_id into idPdOri 
                from pd 
                where pd_code = vPdOri;

            select pd_id into idPdAlt 
                from pd 
                where pd_code = vPdAlt;

            insert into pd_shif_pd (
                pd_id_ori,
                pd_id_alt
            ) values (
                idPdOri,
                idPdAlt
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pd_shif_pd;
end
&&
delimiter ;
call proc_insrt_pd_shif_pd();
