DROP TABLE IF EXISTS "UPVOTES_COMMENTS";
DROP TABLE IF EXISTS "UPVOTES_POSTS";
DROP TABLE IF EXISTS "COMMENTS";
DROP TABLE IF EXISTS "POSTS";
DROP TABLE IF EXISTS "USERS";

CREATE TABLE "USERS" (
	"id" serial NOT NULL,
	"mail" text NOT NULL UNIQUE,
	"passhash" text NOT NULL,
	"username" text NOT NULL UNIQUE,
	CONSTRAINT USERS_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "POSTS" (
	"id" serial NOT NULL,
	"url" text NOT NULL,
	"id_user" serial NOT NULL,
	CONSTRAINT POSTS_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "COMMENTS" (
	"id" serial NOT NULL,
	"id_user" serial NOT NULL,
	"id_post" serial NOT NULL,
	"date" TIMESTAMP NOT NULL,
	"data" TEXT NOT NULL,
	"previous_id" INTEGER,
	CONSTRAINT COMMENTS_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "UPVOTES_POSTS" (
	"id_user" serial NOT NULL,
	"id_post" serial NOT NULL
) WITH (
  OIDS=FALSE
);

CREATE TABLE "UPVOTES_COMMENTS" (
	"id_user" serial NOT NULL,
	"id_comment" serial NOT NULL
) WITH (
  OIDS=FALSE
);


ALTER TABLE "POSTS" ADD CONSTRAINT "POSTS_fk0" FOREIGN KEY ("id_user") REFERENCES "USERS"("id");

ALTER TABLE "COMMENTS" ADD CONSTRAINT "COMMENTS_fk0" FOREIGN KEY ("id_user") REFERENCES "USERS"("id");
ALTER TABLE "COMMENTS" ADD CONSTRAINT "COMMENTS_fk1" FOREIGN KEY ("id_post") REFERENCES "POSTS"("id");
ALTER TABLE "COMMENTS" ADD CONSTRAINT "COMMENTS_fk2" FOREIGN KEY ("previous_id") REFERENCES "COMMENTS"("id");

ALTER TABLE "UPVOTES_POSTS" ADD CONSTRAINT "UPVOTES_POSTS_fk0" FOREIGN KEY ("id_user") REFERENCES "USERS"("id");
ALTER TABLE "UPVOTES_POSTS" ADD CONSTRAINT "UPVOTES_POSTS_fk1" FOREIGN KEY ("id_post") REFERENCES "POSTS"("id");

ALTER TABLE "UPVOTES_COMMENTS" ADD CONSTRAINT "UPVOTES_COMMENTS_fk0" FOREIGN KEY ("id_user") REFERENCES "USERS"("id");
ALTER TABLE "UPVOTES_COMMENTS" ADD CONSTRAINT "UPVOTES_COMMENTS_fk1" FOREIGN KEY ("id_comment") REFERENCES "COMMENTS"("id");


INSERT INTO "USERS"("mail","passhash","username") VALUES('gr3ggz@gmail.com','fdsfds432432432','gr3ggz');
INSERT INTO "USERS"("mail","passhash","username") VALUES('stan@gmail.com','dsdas9900','stan');
INSERT INTO "USERS"("mail","passhash","username") VALUES('test@gmail.com','nvjnvj34343','test');

INSERT INTO "POSTS"("url","id_user") VALUES('porn.jpg',1);
INSERT INTO "POSTS"("url","id_user") VALUES('porn.jpg',2);

INSERT INTO "COMMENTS"("id_user","id_post","date","data") VALUES(3,1,NOW(),'vraiment de la merde');
INSERT INTO "COMMENTS"("id_user","id_post","date","data","previous_id") VALUES(2,1,NOW(),'tg toi',1);

INSERT INTO "UPVOTES_POSTS"("id_user","id_post") VALUES(2,1);
INSERT INTO "UPVOTES_POSTS"("id_user","id_post") VALUES(1,2);

INSERT INTO "UPVOTES_COMMENTS"("id_user","id_comment") VALUES(3,1);
INSERT INTO "UPVOTES_COMMENTS"("id_user","id_comment") VALUES(1,2);
INSERT INTO "UPVOTES_COMMENTS"("id_user","id_comment") VALUES(2,2);