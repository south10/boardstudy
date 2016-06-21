CREATE DATABASE book_ex DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `tbl_board` (
  `bno`     INT(11)      NOT NULL AUTO_INCREMENT,
  `title`   VARCHAR(200) NOT NULL,
  `content` TEXT         NULL,
  `writer`  VARCHAR(50)  NOT NULL,
  `regdate` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `viewcnt` INT(11)      NULL     DEFAULT '0',
  PRIMARY KEY (`bno`)
)
  COLLATE = 'utf8_general_ci'
  ENGINE = InnoDB
  AUTO_INCREMENT = 393199;

CREATE TABLE `tbl_member` (
  `userid`     VARCHAR(50)  NOT NULL,
  `userpw`     VARCHAR(50)  NOT NULL,
  `username`   VARCHAR(50)  NOT NULL,
  `email`      VARCHAR(100) NULL     DEFAULT NULL,
  `regdate`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedate` TIMESTAMP    NULL     DEFAULT NULL,
  PRIMARY KEY (`userid`)
)
  COLLATE = 'utf8_general_ci'
  ENGINE = InnoDB;

CREATE TABLE `tbl_reply` (
  `rno`        INT(11)       NOT NULL AUTO_INCREMENT,
  `bno`        INT(11)       NOT NULL DEFAULT '0',
  `replytext`  VARCHAR(1000) NOT NULL,
  `replyer`    VARCHAR(50)   NOT NULL,
  `regdate`    TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedate` TIMESTAMP     NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`rno`),
  INDEX `FK_BOARD` (`bno`),
  CONSTRAINT `FK_BOARD` FOREIGN KEY (`bno`) REFERENCES `tbl_board` (`bno`)
)
  COLLATE = 'utf8_general_ci'
  ENGINE = InnoDB
  AUTO_INCREMENT = 27;

CREATE TABLE tbl_user (
  uid    VARCHAR(50)  NOT NULL,
  upw    VARCHAR(50)  NOT NULL,
  uname  VARCHAR(100) NOT NULL,
  upoint INT          NOT NULL DEFAULT 0,
  PRIMARY KEY (uid)
);

CREATE TABLE tbl_message (
  mid      INT         NOT NULL AUTO_INCREMENT,
  targetid VARCHAR(50) NOT NULL,
  sender   VARCHAR(50) NOT NULL,
  message  TEXT        NOT NULL,
  opendate TIMESTAMP   NOT NULL DEFAULT '0000-00-00 00:00:00',
  senddate TIMESTAMP   NOT NULL DEFAULT now(),
  PRIMARY KEY (mid)
);

ALTER TABLE tbl_message
  ADD CONSTRAINT fk_usertarget
FOREIGN KEY (targetid) REFERENCES tbl_user (uid);
ALTER TABLE tbl_message
  ADD CONSTRAINT fk_usersender
FOREIGN KEY (sender) REFERENCES tbl_user (uid);

INSERT INTO tbl_user (uid, upw, uname) VALUES ('user00', 'user00', 'IRON MAN');
INSERT INTO tbl_user (uid, upw, uname) VALUES ('user01', 'user01', 'CAPTAIN');
INSERT INTO tbl_user (uid, upw, uname) VALUES ('user02', 'user02', 'HULK');
INSERT INTO tbl_user (uid, upw, uname) VALUES ('user03', 'user03', 'Thor');
INSERT INTO tbl_user (uid, upw, uname) VALUES ('user10', 'user10', 'Quick Silver');

ALTER TABLE tbl_board
  ADD COLUMN replycnt INT DEFAULT 0;

create table tbl_attach(
  fullName varchar(150) not null,
  bno int not null,
  regdate timestamp default now(),
  primary key(fullName)
);

alter table tbl_attach add constraint fk_board_attach
foreign key (bno) references tbl_board(bno);