package it.unicam.cs.hackhub.common;

/**
 * Maps between entity E and input/output DTOs.
 *
 * @param <E>   entity type
 * @param <IN>  input DTO type
 * @param <OUT> output DTO type
 */
public interface ModelMapper<E, IN, OUT> {

    /**
     * Creates a new entity from an input DTO.
     */
    E toEntity(IN dto);

    /**
     * Converts an entity to an output DTO.
     */
    OUT toOutDto(E entity);

    /**
     * Updates an existing entity with data from an input DTO.
     */
    void updateEntity(IN dto, E entity);
}
