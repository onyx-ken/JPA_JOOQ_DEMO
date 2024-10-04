-- Insert Teams
INSERT INTO team (name, description) VALUES ('에스파', 'SM ENT Idol Group');
INSERT INTO team (name, description) VALUES ('르세라핌', 'Source Music Idol Group');

-- Insert Members for 에스파 (Assuming team_id = 1)
INSERT INTO member (name, team_id) VALUES ('카리나', 1);
INSERT INTO member (name, team_id) VALUES ('지젤', 1);
INSERT INTO member (name, team_id) VALUES ('윈터', 1);
INSERT INTO member (name, team_id) VALUES ('닝닝', 1);

-- Insert Members for 르세라핌 (Assuming team_id = 2)
INSERT INTO member (name, team_id) VALUES ('사쿠라', 2);
INSERT INTO member (name, team_id) VALUES ('김채원', 2);
INSERT INTO member (name, team_id) VALUES ('허윤진', 2);
INSERT INTO member (name, team_id) VALUES ('카즈하', 2);
INSERT INTO member (name, team_id) VALUES ('홍은채', 2);
