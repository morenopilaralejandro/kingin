drop table if exists aux_pw_crse;
create temporary table aux_pw_crse (
    pw_crse_code varchar(32),
    pw_crse_name_en varchar(32),	
    pw_crse_name_ja varchar(32),
    pw_unlc varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pw-crse.csv'
into table aux_pw_crse 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pw_crse_code,
pw_crse_name_en,	
pw_crse_name_ja,
pw_unlc
);

delimiter &&
drop procedure if exists proc_insrt_pw_crse;
create procedure proc_insrt_pw_crse()
begin
	declare i int default 1;

    declare idPwUnlc int default 0;

    /*cur1 variables*/
    declare vPwCrseCode varchar(32) default '';
    declare vPwCrseNameEn varchar(32) default '';
    declare vPwCrseNameJa varchar(32) default '';
    declare vPwUnlc varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pw_crse;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pw_crse;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vPwCrseCode, 
            vPwCrseNameEn, 
            vPwCrseNameJa,
            vPwUnlc;

        set idPwUnlc = 0;

        if continueCur1 = 1 then
            select pw_unlc_id into idPwUnlc 
                from pw_unlc
                where pw_unlc_code = vPwUnlc;

            insert into pw_crse (
                pw_crse_code,
                pw_crse_name_en,
                pw_crse_name_ja,
                pw_unlc_id
            ) values (
                vPwCrseCode,
                vPwCrseNameEn,
                vPwCrseNameJa,
                idPwUnlc
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pw_crse;
end
&&
delimiter ;
call proc_insrt_pw_crse();
