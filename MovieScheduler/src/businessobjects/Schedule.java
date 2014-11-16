package businessobjects;

import java.util.GregorianCalendar;

/**
 *  Class representing the filming schedule for scenes in the script.
 */
public class Schedule extends BusinessObjectList<SceneFilmingDate> {
        
    /**
     * Returns a list of all the SceneFilmingDates in the Schedule which are
     * currently in conflict.
     * @return A list of all the SceneFilmingDates in the Schedule which are
     * currently in conflict.
     */
    public BusinessObjectList<SceneFilmingDate> scheduleConflicts()
    {
        BusinessObjectList<SceneFilmingDate> conflictingSceneFilmingDates = 
                new BusinessObjectList<>();
        
        for(SceneFilmingDate currentFilmingDate : this)
        {
            if (currentFilmingDate.hasConflict())
                conflictingSceneFilmingDates.add(currentFilmingDate);
        }
        
        return conflictingSceneFilmingDates;
    }
    
    /**
     * Returns a list of all the SceneFilmingDates which are scheduled to occur
     * on the provided date
     * @param date::GregorianCalendar ~ The date to returns the list of 
     * scheduled SceneFilmingDates, note that the time elements are ignored
     * @return A list of all the SceneFilmingDates which occur on the provided
     * date.
     */
    public BusinessObjectList<SceneFilmingDate> scheduleFor(GregorianCalendar date)
    {
        BusinessObjectList<SceneFilmingDate> returnFilmingDates = 
                new BusinessObjectList<>();
        
        for (SceneFilmingDate currentFilmingDate : this)
        {
            if (currentFilmingDate.sceneShootingInterval().overlaps(date))
                returnFilmingDates.add(currentFilmingDate);
        }
        
        returnFilmingDates.sort(null);
        return returnFilmingDates;
    }
    
    /**
     * Returns the SceneFilmingDate in the Schedule for the provided Scene
     * @param scene::Scene ~ The Scene whose filming date is to be searched for
     * @return The SceneFilmingDate for the provided Scene, or null if the
     * Scene is not yet scheduled.
     */
    public SceneFilmingDate scenesFilmingDate(Scene scene)
    {
        for (SceneFilmingDate currentFilmingDate : this)
        {
            if(currentFilmingDate.scene() == scene)
                return currentFilmingDate;
        }
        return null;
    }
}
