Jesse Yue jty4
Date started: January 15, 2017	Date finished: January 22, 2017
Hours worked: 40
Resources: Oracle JavaFx Documentation
Known bugs: 
	Statusbar isn't instantly updated when switching to new level
	Paddle can go off screen a bit
	Ball sometimes goes through blocks if hit near a corner
	Ball will sometimes get stuck on paddle when at edge
Something to note is that the ball will automatically start moving when the level starts so be ready
Also the animation function is being called within the animation function which caused a lot of problems but I have set up many workarounds that may be confusing.

Levels: 3 levels of different block configurations with increasing difficulty
Blocks: 
	Regular block: rainbow colored, (1 hit)
	Stone block: (2 hits)
	Iron block: (3 hits)
	Powerup block: activates powerup (1 hit)
Paddle: 
	Decreases in size each level
	Ball reflects differently at the edges
	One powerup from powerup block increases paddle size
Power-ups: 
	Fireball: ball goes through blocks
	Increase Ball Size: ball size doubles
	Increase Paddle Size: paddle size triples from the smallest size
Status Display: Shows score, level, and lives
Splash Screen: Shows title, controls, rules, and buttons to start ot quit
Cheat Codes: 
	S: skip to next level
	L: add 1000 lives
	P: play/pause
	SPACE: all powerups
Extra: Surprise boss level

Impressions: This assignment was thoroughly challenging for me but I wouldn't change anything. I feel like I've learned a lot already but I know I still have a lot of room for improvement. The design of this program is definitely not great but it's definitely better than the first iteration where evreything was in one file.