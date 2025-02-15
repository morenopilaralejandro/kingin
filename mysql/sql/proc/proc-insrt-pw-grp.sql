drop table if exists aux_pw_grp;
create temporary table aux_pw_grp (
    pw_grp_code varchar(32),
    pw_grp_name_en varchar(32),	
    pw_grp_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pw-grp.csv'
into table aux_pw_grp 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pw_grp_code,
pw_grp_name_en,	
pw_grp_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_pw_grp;
create procedure proc_insrt_pw_grp()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vCurrCode varchar(32) default '';
    declare vCurrNameEn varchar(32) default '';
    declare vCurrNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pw_grp;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pw_grp;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vCurrCode, 
            vCurrNameEn, 
            vCurrNameJa;
        if continueCur1 = 1 then
            insert into pw_grp (
                pw_grp_code,
                pw_grp_name_en,	
                pw_grp_name_ja
            ) values (
                vCurrCode,
                vCurrNameEn,
                vCurrNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pw_grp;
end
&&
delimiter ;
call proc_insrt_pw_grp();
