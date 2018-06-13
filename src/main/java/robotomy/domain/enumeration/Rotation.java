package robotomy.domain.enumeration;

public enum Rotation {
  LEFT(-1),
  RIGHT(1);

  private Integer cardinalOffset;

  Rotation(Integer cardinalOffset) {
    this.cardinalOffset = cardinalOffset;
  }

  public Integer getCardinalOffset() {
    return cardinalOffset;
  }
}
