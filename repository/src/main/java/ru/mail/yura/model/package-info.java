/**
 * 
 */
/**
 * @author User
 *
 */
@org.hibernate.annotations.GenericGenerator(
name = "ID_GENERATOR",
strategy = "sequence-identity",
parameters = {
  @org.hibernate.annotations.Parameter(
  name = "sequence_name",
  value = "JPWH_SEQUENCE_IDENTITY"
  ),
  @org.hibernate.annotations.Parameter(
  name = "initial_value",
  value = "1000"
  )
})
package ru.mail.yura.model;