package com.github.omerucel.jcosmos;

import com.github.omerucel.jcosmos.error.InternalServerError;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

public class CommandManagerTest {
    @Test
    public void execute()
    {
        ICommand dummyCommand = Mockito.spy(new ICommand(){

            public Response run() {
                return new Response();
            }
        });

        CommandManager commandManager = new CommandManager();
        Response response = commandManager.execute(dummyCommand);
        assertFalse(response.hasError());

        dummyCommand = Mockito.spy(new ICommand() {

            public Response run() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        response = commandManager.execute(dummyCommand);
        assertTrue(response.hasError());
        assertTrue(response.hasError(InternalServerError.class));
    }
}
