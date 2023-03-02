package model;

import java.beans.PropertyChangeListener;

/**
 *
 * Defines behaviors allowing PropertyChangeListeners to be added or removed from a
 * Board object. Implementing classes should inform PropertyChangeListeners
 * when methods defined in BoardControls mutate the state of the simulation.
 *
 * @author David Hoang
 * @author Avinash Bavisetty
 * @author Yonas Omega
 * @author Jose Rodriguez
 * @version Winter 2023
 */
public interface PropertyChangeEnabledBoardControls extends BoardControls {

    /**
     * These are the constant property values.
     *
     */


    /**
     * A property name for the current GAME_OVER property in the game.
     */
    String PROPERTY_GAME_OVER = "GAMEOVER";
    /**
     * A property name for the myDrop status.
     */
    String PROPERTY_DROP = "DROP";
    /**
     * A property name for the myDrop status.
     */
    String PROPERTY_SEQUENCE_INDEX = "INDEX";
    /**
     * A property name for the size of the list of frozen blocks is changed.
     */
    String PROPERTY_FROZEN_BLOCKS_SIZE= "SIZE";
    /**
     * A property name for when current piece has  changed.
     */
    String PROPERTY_CURRENT_PIECE= "CURRENT_PIECE";
    /**
     * A property name for when the list of current rows has been changed.
     */
    String PROPERTY_COMPLETE_ROWS_LIST= "CURRENT_PIECE";



    /**
     * Add a PropertyChangeListener to the listener list. The listener is registered for
     * all properties. The same listener object may be added more than once, and will be
     * called as many times as it is added. If listener is null, no exception is thrown and
     * no action is taken.
     *
     * @param theListener The PropertyChangeListener to be added
     */
    void addPropertyChangeListener(PropertyChangeListener theListener);


    /**
     * Add a PropertyChangeListener for a specific property. The listener will be invoked only
     * when a call on firePropertyChange names that specific property. The same listener object
     * may be added more than once. For each property, the listener will be invoked the number
     * of times it was added for that property. If propertyName or listener is null, no
     * exception is thrown and no action is taken.
     *
     * @param thePropertyName The name of the property to listen on.
     * @param theListener The PropertyChangeListener to be added
     */
    void addPropertyChangeListener(String thePropertyName, PropertyChangeListener theListener);

    /**
     * Remove a PropertyChangeListener from the listener list. This removes a
     * PropertyChangeListener that was registered for all properties. If listener was added
     * more than once to the same event source, it will be notified one less time after being
     * removed. If listener is null, or was never added, no exception is thrown and no action
     * is taken.
     *
     * @param theListener The PropertyChangeListener to be removed
     */
    void removePropertyChangeListener(PropertyChangeListener theListener);

    /**
     * Remove a PropertyChangeListener for a specific property. If listener was added more than
     * once to the same event source for the specified property, it will be notified one less
     * time after being removed. If propertyName is null, no exception is thrown and no action
     * is taken. If listener is null, or was never added for the specified property, no
     * exception is thrown and no action is taken.
     *
     * @param thePropertyName The name of the property that was listened on.
     * @param theListener The PropertyChangeListener to be removed
     */
    void removePropertyChangeListener(String thePropertyName,
                                      PropertyChangeListener theListener);
}
