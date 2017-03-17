package com.example.mrtan.data.net;

import dagger.Component;
import javax.inject.Singleton;

/**
 * @author mrtan 17-3-16
 */
@Component(modules = NetModule.class) @Singleton public interface NetComponent {
  RestApi getRestApi();
}
