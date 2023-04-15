CREATE TABLE poll_item
(
    poll_item_id       INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    poll_item_name     VARCHAR(128) NOT NULL,
    poll_item_description VARCHAR(256) ,
    poll_item_email  VARCHAR(256) NOT NULL,
    poll_item_count INT  NOT NULL,
    poll_item_state    VARCHAR(20) NOT NULL,
    poll_item_gftm     TIMESTAMP NOT NULL,
    poll_item_txtm     TIMESTAMP NOT NULL,
    FOREIGN KEY (poll_item_email) REFERENCES USER(user_email)
);

CREATE TABLE poll_detail
(
    poll_detail_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    poll_detail_itemId INT NOT NULL,
    poll_detail_userEmail VARCHAR(256) NOT NULL,
    poll_detail_gftm TIMESTAMP NOT NULL,
    FOREIGN KEY (poll_detail_itemId) REFERENCES poll_item(poll_item_id),
    FOREIGN KEY (poll_detail_userEmail) REFERENCES USER(user_email)
);

CREATE TABLE USER
(
    user_id            INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_name	       VARCHAR(32) NOT NULL,
    user_email         VARCHAR(256) NOT NULL UNIQUE KEY,
    user_password      VARCHAR(256) NOT NULL,
    user_gftm          TIMESTAMP    NOT NULL,
    user_txtm          TIMESTAMP    NOT NULL
);
