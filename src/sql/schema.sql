CREATE TABLE player (
  player_name VARCHAR(45) NOT NULL,
  player_nb_wins INTEGER UNSIGNED NOT NULL DEFAULT 0,
  player_nb_losses INTEGER UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY(player_name),
  UNIQUE KEY(player_name)
);

CREATE TABLE game (
  game_name VARCHAR(45) NOT NULL,
  game_white_player VARCHAR(45) NOT NULL,
  game_black_player VARCHAR(45) NOT NULL,
  game_last_player VARCHAR(45) NULL,
  game_ia_white_player INTEGER UNSIGNED NOT NULL DEFAULT 0,
  game_ia_black_player INTEGER UNSIGNED NOT NULL DEFAULT 0,
  game_help BOOLEAN NOT NULL DEFAULT TRUE,
  game_start BOOLEAN NOT NULL DEFAULT FALSE,
  PRIMARY KEY(game_name),
  UNIQUE KEY(game_name),
  INDEX game_FKIndex1(game_white_player),
  INDEX game_FKIndex2(game_black_player),
  INDEX game_FKIndex3(game_last_player),
  FOREIGN KEY(game_white_player)
    REFERENCES player(player_name)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(game_black_player)
    REFERENCES player(player_name)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(game_last_player)
    REFERENCES player(player_name)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);

CREATE TABLE board (
    game_name VARCHAR(45) NOT NULL,
    board_nb_cases INTEGER UNSIGNED NOT NULL,
    PRIMARY KEY(game_name),
    UNIQUE KEY(game_name),
    FOREIGN KEY(game_name)
        REFERENCES game(game_name)
          ON DELETE CASCADE
          ON UPDATE CASCADE
);

CREATE TABLE square (
  square_x INTEGER UNSIGNED NOT NULL,
  square_y INTEGER UNSIGNED NOT NULL,
  game_name VARCHAR(45) NOT NULL,
  square_pawn INTEGER NOT NULL DEFAULT -1,
  PRIMARY KEY(square_x, square_y, game_name),
  UNIQUE KEY(square_x, square_y, game_name),
  INDEX square_FKIndex1(game_name),
  FOREIGN KEY(game_name)
    REFERENCES board(game_name)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);


