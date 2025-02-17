drop table if exists aux_npc_title;
create temporary table aux_npc_title (
    npc_title_code varchar(32),
    npc_title_name_en varchar(32),	
    npc_title_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/npc-title.csv'
into table aux_npc_title 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
npc_title_code,
npc_title_name_en,	
npc_title_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_npc_title;
create procedure proc_insrt_npc_title()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vNpcTitleCode varchar(32) default '';
    declare vNpcTitleNameEn varchar(32) default '';
    declare vNpcTitleNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_npc_title;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from npc_title;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vNpcTitleCode, 
            vNpcTitleNameEn, 
            vNpcTitleNameJa;
        if continueCur1 = 1 then
            insert into npc_title (
                npc_title_code,
                npc_title_name_en,	
                npc_title_name_ja
            ) values (
                vNpcTitleCode,
                vNpcTitleNameEn,
                vNpcTitleNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_npc_title;
end
&&
delimiter ;
call proc_insrt_npc_title();
