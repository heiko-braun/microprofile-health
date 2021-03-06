/*
 * Copyright (c) 2017 Contributors to the Eclipse Foundation
 *
 * See the NOTICES file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */
package org.eclipse.microprofile.health.tck.deployment;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.health.HealthStatus;
import org.eclipse.microprofile.health.inject.Health;


/**
 * @author Heiko Braun
 */
@Path("/success")
public class SuccessfulChecks {


    @GET
    @Health
    @Path("/first")
    public HealthStatus checkHealth() {
        return HealthStatus.named("first").up();
    }

    @GET
    @Health
    @Path("/second")
    public HealthStatus checkHealthInsecure() {
        return HealthStatus.named("second").up().withAttribute("time", System.currentTimeMillis());
    }
}
