drop table if exists aux_pw_unlc;
create temporary table aux_pw_unlc (
    pw_unlc_code varchar(32),
    pw_unlc_desc_en varchar(32),	
    pw_unlc_desc_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pw-unlc.csv'
into table aux_pw_unlc 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pw_unlc_code,
pw_unlc_desc_en,	
pw_unlc_desc_ja
);

delimiter &&
drop procedure if exists proc_insrt_pw_unlc;
create procedure proc_insrt_pw_unlc()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vPwUnlcCode varchar(32) default '';
    declare vPwUnlcDescEn varchar(32) default '';
    declare vPwUnlcDescJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pw_unlc;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pw_unlc;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vPwUnlcCode, 
            vPwUnlcDescEn, 
            vPwUnlcDescJa;
        if continueCur1 = 1 then
            insert into pw_unlc (
                pw_unlc_code,
                pw_unlc_desc_en,	
                pw_unlc_desc_ja
            ) values (
                vPwUnlcCode,
                vPwUnlcDescEn,
                vPwUnlcDescJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pw_unlc;
end
&&
delimiter ;
call proc_insrt_pw_unlc();
