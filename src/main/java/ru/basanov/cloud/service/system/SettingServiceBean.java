package ru.basanov.cloud.service.system;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import ru.basanov.cloud.api.annotation.Loggable;
import ru.basanov.cloud.api.system.SettingService;

import javax.enterprise.context.ApplicationScoped;
import java.io.InputStream;
import java.util.Properties;

@Getter
@Setter
@ApplicationScoped
public class SettingServiceBean implements SettingService {

    private static final String FILE_NAME = "application.properties";

    private static final String KEY_JCR_URL = "jcr.url";

    private static final String KEY_JCR_LOGIN = "jcr.login";

    private static final String KEY_JCR_PASSWORD = "jsr.password";

    private static final String KEY_SYNC_FOLDER = "sync.folder";

    private static final String KEY_SYNC_TIMEOUT = "sync.timeout";

    private static final String KEY_SYNC_ENDPOINT = "sync.endpoint";

    private static final String KEY_SYNC_ACTIVE = "sync.active";

    private static final String KEY_JCR_ACTIVE = "jcr.active";

    private String jcrUrl;

    private String jcrLogin;

    private String jcrPassword;

    private Boolean jcrActive;

    private String syncFolder;

    private Integer syncTimeout;

    private String syncEndpoint;

    private Boolean syncActive;

    @Loggable
    @SneakyThrows
    public void init() {
        final Properties properties = new Properties();
        final ClassLoader classLoader = SettingServiceBean.class.getClassLoader();
        final InputStream inputStream = classLoader.getResourceAsStream(FILE_NAME);
        properties.load(inputStream);
        jcrUrl = properties.getOrDefault(KEY_JCR_URL, "localhost").toString();
        jcrLogin = properties.getOrDefault(KEY_JCR_LOGIN, "admin").toString();
        jcrPassword = properties.getOrDefault(KEY_JCR_PASSWORD, "admin").toString();
        jcrActive = Boolean.parseBoolean(properties.getOrDefault(KEY_JCR_ACTIVE, "true").toString());
        syncFolder = properties.getOrDefault(KEY_SYNC_FOLDER, "./temp/").toString();
        syncTimeout = Integer.parseInt(properties.getOrDefault(KEY_SYNC_TIMEOUT, "1000").toString());
        syncActive = Boolean.parseBoolean(properties.getOrDefault(KEY_SYNC_ACTIVE, "true").toString());
        syncEndpoint = properties.getOrDefault(KEY_SYNC_ENDPOINT, "http://localhost:8181/").toString();
    }

    @Override
    public @NotNull Boolean getJcrActive() {
        return null;
    }

    @Override
    public @NotNull String getJcrUrl() {
        return null;
    }

    @Override
    public @NotNull String getJcrLogin() {
        return null;
    }

    @Override
    public @NotNull String getJcrPassword() {
        return null;
    }

    @Override
    public @NotNull String getSyncFolder() {
        return null;
    }

    @Override
    public @NotNull Integer getSyncTimeout() {
        return null;
    }

    @Override
    public @NotNull String getSencEndpoint() {
        return null;
    }

    @Override
    public @NotNull Boolean getSyncActive() {
        return null;
    }

}
