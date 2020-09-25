# Debugging the OML Diagram Server

To run the oml-theia IDE we need to first start the server and then run the ide either in the browser or in electron as described in the oml-theia repository.

First create a debug configuration in the Eclipse IDE. In the Eclipse toolbar, click on the dropdown arrow next to the debug icon and select `Debug Configurations...`

In the list on the left, select `Java Application`. Click on the `New Launch Configuration` button in the toolbar.

Click on `Browse...` next to the Project input field and select `io.opencaesar.oml.dsl.ide.server` and click OK.

Click on `Search...` next to the Main class input field and search for `OmlRunSocketServer`, select it and click OK.

Click on the Arguments tab and in the Program arguments field add `-port 5009`

Click on `Apply`, and now you can click on `Debug` to debug the server application.

After starting the server application, you can now run the IDE application and it will connect to the server on startup.

## Starting the oml-theia IDE

Clone the oml-theia repository and `cd` into the inner `oml-theia` folder. Build the oml-theia repository with `yarn`.

To run the electron application, you need to rebuild it with `yarn rebuild:electron` first.

Now you can run `yarn start:electron-socket-server` to run the ide.
