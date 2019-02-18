package com.superheroworld.game.data.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.superheroworld.game.commons.util.FileUtil;
import com.superheroworld.game.data.model.ApplicationState;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.when;

import static com.superheroworld.game.TestUtil.getDummyApplicationState;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FileUtil.class)
public class ApplicationStateDaoTest {

    private ApplicationStateDao applicationStateDao;

    @Before
    public void setUp() {
        applicationStateDao = new ApplicationStateDao();
        PowerMockito.mockStatic(FileUtil.class);
    }

    @Test
    public void testSave() {
        ApplicationState applicationState = getDummyApplicationState();

        applicationStateDao.save(applicationState);
        PowerMockito.verifyStatic(VerificationModeFactory.times(1));
    }

    @Test
    public void testLoad() {
        ApplicationState applicationState = getDummyApplicationState();

        when(FileUtil.readFromFile(anyString())).thenReturn(applicationState);
        ApplicationState loadedState = applicationStateDao.load();
        PowerMockito.verifyStatic(VerificationModeFactory.times(1));
        assertEquals(applicationState, loadedState);
    }
}
