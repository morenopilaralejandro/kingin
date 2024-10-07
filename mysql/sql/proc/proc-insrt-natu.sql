drop table if exists aux_natu;
create temporary table aux_natu (
    natu_code varchar(32),
    natu_name_en varchar(1000),
    natu_name_ja varchar(1000),
    stat_code_red varchar(32),
    stat_code_blue varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/natu.csv'
into table aux_natu 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
natu_code,
natu_name_en,
natu_name_ja,
stat_code_red,
stat_code_blue
);

delimiter &&
drop procedure if exists proc_insrt_natu;
create procedure proc_insrt_natu()
begin
	declare i int default 1;

    declare idStatRed int default 0;
    declare idStatBlue int default 0;

    /*cur1 variables*/
    declare vNatuCode varchar(32) default '';
    declare vNatuNameEn varchar(1000) default '';
    declare vNatuNameJa varchar(1000) default '';
    declare vStatCodeRed varchar(32) default '';
    declare vStatCodeBlue varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_natu;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from natu;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vNatuCode,
            vNatuNameEn,
            vNatuNameJa,
            vStatCodeRed,
            vStatCodeBlue;

        set idStatRed = 0;
        set idStatBlue = 0;

        if continueCur1 = 1 then
            select stat_id into idStatRed 
                from stat
                where stat_code = vStatCodeRed;

            select stat_id into idStatBlue
                from stat
                where stat_code = vStatCodeBlue;

            insert into natu (
                natu_code,
                natu_name_en,
                natu_name_ja,
                stat_id_red,
                stat_id_blue
            ) values (
                vNatuCode,
                vNatuNameEn,
                vNatuNameJa,
                idStatRed,
                idStatBlue
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_natu;
end
&&
delimiter ;
call proc_insrt_natu();
