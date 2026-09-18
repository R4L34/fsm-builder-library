package com.r4l.snipers_mini_game.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.r4l.snipers_mini_game.Reference;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

public class CommandHandler {

	@EventBusSubscriber(modid = Reference.MODID)
	public static class Server {

		@SubscribeEvent
		public static void onRegisterCommands(RegisterCommandsEvent event) {
			CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

	        // /#team commands
	        dispatcher.register(Commands.literal("#team")
	            .then(Commands.literal("create")
	                .then(Commands.argument("NAME", StringArgumentType.word())
	                    .executes(c -> 1)))
	            
	            .then(Commands.literal("destroy")
	                .then(Commands.argument("NAME", StringArgumentType.word())
	                    .executes(c -> 1)))
	            
	            .then(Commands.literal("destroyall")
	                .executes(c -> 1))
	            
	            .then(Commands.literal("add")
	                .then(Commands.argument("NAME", StringArgumentType.word())
	                    .then(Commands.argument("PLAYERS", EntityArgument.players())
	                        .executes(c -> 1))))
	            
	            .then(Commands.literal("remove")
	                .then(Commands.argument("NAME", StringArgumentType.word())
	                    .then(Commands.argument("PLAYERS", EntityArgument.players())
	                        .executes(c -> 1))))
	            
	            .then(Commands.literal("clean")
	                .then(Commands.argument("NAME", StringArgumentType.word())
	                    .executes(c -> 1)))
	            
	            .then(Commands.literal("print")
	                .executes(c -> 1) // Execution for empty optional (/#team print)
	                .then(Commands.argument("NAME", StringArgumentType.word())
	                    .executes(c -> 1))) // Execution with argument (/#team print <NAME>)
	        );

	        // /#start command
	        dispatcher.register(Commands.literal("#start")
	            .executes(c -> 1)
	        );

	        // /#spectate command
	        dispatcher.register(Commands.literal("#spectate")
	            .executes(c -> 1)
	        );

	        // /#reloadTime command
	        dispatcher.register(Commands.literal("#reloadTime")
	            .then(Commands.argument("TICKS", IntegerArgumentType.integer())
	                .executes(c -> 1))
	        );
	    
		}
		
		

	}

	@EventBusSubscriber(modid = Reference.MODID, value = Dist.CLIENT)
	public static class Client {

		@SubscribeEvent
		public static void onRegisterCommands(RegisterClientCommandsEvent event) {
			CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

	        // /#pov commands
	        dispatcher.register(Commands.literal("#pov")
	            .then(Commands.literal("leftHand")
	                .executes(c -> 1))
	            .then(Commands.literal("rightHand")
	                .executes(c -> 1))
	        );

	        // /#sensitivity command
	        dispatcher.register(Commands.literal("#sensitivity")
	            .then(Commands.argument("value", FloatArgumentType.floatArg())
	                .executes(c -> 1))
	        );
	    
		}

	}

}
