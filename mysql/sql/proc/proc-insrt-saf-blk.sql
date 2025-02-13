drop table if exists aux_saf_blk;
create temporary table aux_saf_blk (
    saf_blk_code varchar(32),
    saf_blk_name_en varchar(32),	
    saf_blk_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/saf-blk.csv'
into table aux_saf_blk 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
saf_blk_code,
saf_blk_name_en,	
saf_blk_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_saf_blk;
create procedure proc_insrt_saf_blk()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vsaf_blkCode varchar(32) default '';
    declare vsaf_blkNameEn varchar(32) default '';
    declare vsaf_blkNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_saf_blk;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from saf_blk;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vsaf_blkCode, 
            vsaf_blkNameEn, 
            vsaf_blkNameJa;
        if continueCur1 = 1 then
            insert into saf_blk (
                saf_blk_code,
                saf_blk_name_en,	
                saf_blk_name_ja
            ) values (
                vsaf_blkCode,
                vsaf_blkNameEn,
                vsaf_blkNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_saf_blk;
end
&&
delimiter ;
call proc_insrt_saf_blk();
