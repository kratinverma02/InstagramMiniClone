from flask import Blueprint, request, jsonify
from flask_jwt_extended import jwt_required, get_jwt_identity
from ..extensions import db
from ..models.comment import Comment

comment_bp = Blueprint("comment", __name__, url_prefix="/posts")

@comment_bp.route("/<int:post_id>/comment", methods=["POST"])
@jwt_required()
def comment(post_id):
    user_id = get_jwt_identity()
    db.session.add(
        Comment(
            text=request.json["text"],
            user_id=user_id,
            post_id=post_id
        )
    )
    db.session.commit()
    return jsonify(message="Comment added")
