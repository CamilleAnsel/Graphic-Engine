import java.util.ArrayList;

/**
 * Abstract class representing the core loop of a graphics engine.
 * It manages the engine's lifecycle, execution flow, and synchronization
 * of the graphics loop. The class defines methods to start, stop,
 * and manage the loop execution, and provides abstract methods that
 * subclasses should implement for handling input, updating the scene,
 * and rendering the scene.
 */
public abstract class AbstractedEngineLoop {

    /** Enum representing possible engine states */
    protected enum EngineStatus {
        STOPPED,  // Engine is not running
        RUNNING   // Engine is currently running
    }

    // Fields
    /**
     * Represents the current status of the engine (e.g., RUNNING, STOPPED).
     * Declared as volatile to ensure visibility across multiple threads.
     */
    protected volatile EngineStatus status;

    /**
     * The scene that the engine is rendering and updating.
     */
    protected Scene scene;

    /**
     * The graphic engine responsible for rendering the scene.
     */
    protected AbstractedGraphicEngine graphicEngine;


    protected DisplayWindow displayWindow;

    /**
     * The thread in which the graphics loop runs.
     */
    private Thread graphicsThread;

    // Constructors
    /**
     * Constructor that initializes the engine with a given scene and graphic engine.
     * The engine is initially set to the "STOPPED" state.
     * @param scene The scene that the engine will handle.
     * @param graphicEngine The graphic engine responsible for rendering the scene.
     */
    public AbstractedEngineLoop(Scene scene, AbstractedGraphicEngine graphicEngine, DisplayWindow displayWindow) {
        status = EngineStatus.STOPPED;  // Set initial status to STOPPED
        this.scene = scene;
        this.graphicEngine = graphicEngine;
        this.graphicEngine.setScene(scene); // Set the scene as the scene we want to render
        this.displayWindow = displayWindow;
    }

    // Methods
    /**
     * Starts the engine loop by setting the status to RUNNING and launching
     * a new thread to execute the graphics loop.
     */
    public void run() {
        status = EngineStatus.RUNNING;  // Set status to RUNNING
        graphicsThread = new Thread(this::processEngineLoop);  // Create a new thread for the engine loop
        graphicsThread.start();  // Start the thread
    }

    /**
     * Defines the core execution loop of the engine.
     * This implementation is basic and can be overridden by subclasses,
     * especially to take care of the elapsed time between two frames
     * when updating the scene. The loop processes input, updates the
     * scene, and renders it continuously as long as the engine is running.
     */
    protected void processEngineLoop() {
        while (isEngineRunning()) {
            processInput();  // Process input events
            update(20);  // Update the scene (default time step is 20ms)
            render();  // Render the scene
        }
    }

    /**
     * Stops the engine loop by changing the status to STOPPED.
     * The loop will stop running, and the graphics thread will be terminated.
     */
    public void stop() {
        status = EngineStatus.STOPPED;  // Set the status to STOPPED
    }

    /**
     * Checks whether the engine is currently running.
     * @return true if the engine status is RUNNING, false otherwise.
     */
    public boolean isEngineRunning() {
        return status == EngineStatus.RUNNING;
    }

    // Abstract methods to be implemented by subclasses
    /**
     * Abstract method for handling input processing.
     * This method is called to handle user input or other events
     * in the engine, such as keyboard, mouse, or touch input.
     */
    protected abstract void processInput();

    /**
     * Abstract method for updating the scene and its variables.
     * This method will be called to update the positions of meshes,
     * camera views, and other scene elements.
     * @param elapsedTime The number of milliseconds that have passed
     *                    since the last update.
     */
    protected abstract void update(long elapsedTime);

    /**
     * Rendering the scene.
     * This method is responsible for rendering the current state of
     * the scene to the screen.
     */
    protected void render(){
        ArrayList<Triangle> projection = graphicEngine.projectScene();
        displayWindow.render(projection);
    }
}
