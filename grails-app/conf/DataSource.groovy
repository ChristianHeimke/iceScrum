/*
 * Copyright (c) 2010 iceScrum Technologies.
 *
 * This file is part of iceScrum.
 *
 * iceScrum is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * iceScrum is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with iceScrum.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Authors:
 *
 * Vincent Barrier (vbarrier@kagilum.com)
 * Stephane Maldini (stephane.maldini@icescrum.com)
 */

dataSource {
    driverClassName = "org.hsqldb.jdbcDriver"
    username = "sa"
    password = ""
    pooled = true
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}

// environment specific settings
environments {
    development {
        dataSource {
            /*driverClassName="com.mysql.jdbc.Driver"
            dialect="org.hibernate.dialect.MySQL5InnoDBDialect"
            url="jdbc:mysql://localhost:3306/kagilum?useUnicode=true&characterEncoding=utf8"
            username="root"
            password="root"
            dbCreate = "update"*/
            dbCreate = "update" // one of 'create', 'create-drop','update'
            url = "jdbc:hsqldb:file:devDba"
            loggingSql = false
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:hsqldb:mem:testDba"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:hsqldb:file:prodDba;shutdown=true"
        }
    }
}