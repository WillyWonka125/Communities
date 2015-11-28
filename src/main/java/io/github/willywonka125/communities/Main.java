package io.github.willywonka125.communities;

import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.game.state.GameStoppedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.spec.CommandSpec;

import com.google.inject.Inject;

@Plugin(id = "communities", name = "Communities", version = "0.1")
public class Main { //Fuck yeah don't have to extend anything
	
	//https://docs.spongepowered.org/en/plugin/lifecycle.html - Keep this in mind when doing events / other classes
	
	private Logger logger;
	
	@Inject
	public Main(Logger logger) {
		this.logger = logger;
	}
	
	CommandSpec menuCommand = CommandSpec.builder()
		.description(Texts.of("Primary command for Communities."))
		.executor(new menuCommandExecutor())
		.build();
	
	
	@Listener
	public void onStart (GameStartedServerEvent e) {
		logger.info("Communities successfully initialized.");
		e.getGame().getCommandDispatcher().register(this, menuCommand, "com");
	}
	
	@Listener
	public void onStop (GameStoppedServerEvent e) {
		
	}

}
