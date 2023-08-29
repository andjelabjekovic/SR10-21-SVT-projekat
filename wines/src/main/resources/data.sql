insert into users( username, password, email,last_login,first_name,last_name, display_name,description,role) values ( 'pera', '$2a$10$71vO6Zs6mDlX0i7QoN2Jj.jHFUTAZpNF1TN1Jv.E53ZSxLg97Tbc6', 'email1@gmail.com','11.02.2019. 11:00' ,'firstname1','userlastname1','displayName1','description1','ADMIN')
insert into users( username, password, email,last_login,first_name,last_name, display_name,description,role) values ( 'pera2', '$2a$10$71vO6Zs6mDlX0i7QoN2Jj.jHFUTAZpNF1TN1Jv.E53ZSxLg97Tbc6', 'email2@gmail.com','12.11.2012. 11:00','firstname2' ,'userlastname2','displayName2','description2','USER')
insert into users( username, password, email,last_login,first_name,last_name, display_name,description,role) values ( 'pera3', '$2a$10$71vO6Zs6mDlX0i7QoN2Jj.jHFUTAZpNF1TN1Jv.E53ZSxLg97Tbc6', 'email3@gmail.com','12.01.2012. 11:00','firstname3' ,'userlastname3','displayName2','description3','USER')

insert into groups( name, description, creation_date, is_suspended, suspended_reason) values ( 'group1', 'group for abc', '11.11.2022.', false, '')
insert into groups( name, description, creation_date, is_suspended, suspended_reason) values ( 'group2', 'group for abcd', '11.01.2022.', false, '')


insert into Post( content, creation_date, user_id, group_id) values ( 'tekst234', '11.11.2022. 11:00', 2, 1)
insert into Post( content, creation_date, user_id, group_id) values ( 'tekst', '11.12.2022. 12:00', 1, 2)

insert into Comment( text,timestap,is_deleted,user_id,post_id) values ( 'text1','12.12.2008.',false,3,1)
insert into Comment( text,timestap,is_deleted,user_id,post_id) values ( 'text2','12.02.2008.',true,2,2)

insert into Reaction( type,timestamp,post_id,user_id,comment_id) values ( 0,'12.02.2008.',null,2,1)
insert into Reaction( type,timestamp,post_id,user_id,comment_id) values ( 1,'11.02.2011.',1,2,null)
insert into Reaction( type,timestamp,post_id,user_id,comment_id) values ( 2,'11.02.2011.',2,1,null)

insert into Group_Admin( user_id, group_id) values (2,1)
insert into Group_Admin( user_id, group_id) values (3,2)

