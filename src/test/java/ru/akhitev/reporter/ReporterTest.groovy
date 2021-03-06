/*
 * ru.akhitev.reporter is a library for encryption.
 * Copyright (c) 2014 Aleksei Khitevi (Хитёв Алексей Юрьевич).
 *
 * This file is part of ru.akhitev.encrypter
 *
 * ru.akhitev.reporter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * ru.akhitev.encrypter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
*/

package ru.akhitev.reporter

import org.junit.Before
import org.junit.Test

/**
 * General test
 *
 * @author Aleksei Khitev (alexkhitev@gmail.com)
 */
class ReporterTest {
    Reporter reporterOne
    Reporter reporterTwo
    /**
     * Initialising
     */
    @Before
    void init(){
        reporterOne = new Reporter()
        reporterOne.setProperties("Общий тест", "Ошибки №1", "Ошибки №2","smtp.mail.ru", 2525, "akhitev.testing@mail.ru", "Omega0987", "alexkhitev@gmail.com", "Test sending from ru.akhitev.reporter.ReporterTest")
        reporterOne.addToMessage("1.1 Тест","1.2 Тест","system")
        reporterOne.addToMessage("3.1 Тест","3.2 Тест","other")
    }
    /**
     * Test
     */
    @Test
    void GeneralTest(){
        reporterOne.sendReport()
    }
    @Test
    void FileWithPropertiesTest(){
        reporterTwo = new Reporter("dat${File.separator}reporter.properties")
        reporterTwo.addToMessage("1.1 Тест","1.2 Тест","system")
        reporterTwo.addToMessage("3.1 Тест","3.2 Тест","other")
        reporterTwo.sendReport()
    }
}
