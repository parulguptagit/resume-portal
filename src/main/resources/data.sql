insert into MYUSER (id, user_name, password, active, roles) values
(1, 'einstein', 'einstein', false, 'USER'),
(2, 'parul', 'parul', true, 'USER'),
(3, 'koushik', 'koushik', true, 'USER');

insert into user_profile (id, user_name, theme, summary) values
(1, 'einstein', 1,'foo'),
(2, 'parul', 1,'web'),
(3, 'koushik',2, 'try');